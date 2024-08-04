package personal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banking {
	public static void main(String[] args) {
	}

	String[] solution(String[][] queries) {
		String[] res = new String[queries.length];
		Bank bank = new Bank();
		for (int i = 0; i < queries.length; i++) {
			String query = queries[i][0];
			String accountId = queries[i][2];
			String amount = "";

			if (queries[i].length > 3) {
				amount = queries[i][3];
			}
			switch (query) {
				case "CREATE_ACCOUNT" -> {
					res[i] = bank.createAccount(accountId) + "";
				}
				case "DEPOSIT" -> {
					res[i] = bank.deposit(accountId, Double.parseDouble(amount));
				}
				case "PAY" -> {
					res[i] = bank.pay(accountId, Double.parseDouble(amount));
				}
				case "TOP_ACTIVITY" -> {
					String topActivity = queries[i][2];
					res[i] = bank.topActivity(Integer.parseInt(topActivity));
				}
				case "TRANSFER" -> {
					String sourceAccountId = queries[i][2];
					String targetAccountId = queries[i][3];
					amount = queries[i][4];
					res[i] = bank.scheduleTransfer(sourceAccountId, targetAccountId, Double.parseDouble(amount));
				}
				case "ACCEPT_TRANSFER" -> {
					String transferSourceAccountId = queries[i][2];
					String transferId = queries[i][3];
					res[i] = bank.checkTransferStatus(transferId, transferSourceAccountId);
				}
			}
		}
		return res;
	}

}
record Transaction(String accountId, double totalTransactions) {


}
class Transfer {
	private final long timestamp;
	private final double amount;
	private final String targetAccount;
	private final String sourceAccount;
	public Transfer(long timestamp, double amount, String source, String target){
		this.timestamp = timestamp;
		this.amount = amount;
		this.sourceAccount = source;
		this.targetAccount= target;
	}
	public double getAmount(){
		return this.amount;
	}
	public long getTimeStamp(){
		return this.timestamp;
	}
	public String getSource(){
		return this.sourceAccount;
	}
	public String getTarget(){
		return this.targetAccount;
	}
}
class Bank {
	private final Map<String, BankAccount> accounts;
	private final Map<String, Transfer> scheduledTransfers;

	public Bank() {
		this.accounts = new HashMap<>();
		this.scheduledTransfers = new HashMap<>();
	}

	public boolean createAccount(String accountId) {
		if (!accounts.containsKey(accountId)) {
			BankAccount account = new BankAccount(accountId);
			accounts.put(accountId, account);
			return true;
		}
		return false;
	}

	public String deposit(String accountId, double amount) {
		BankAccount account = accounts.get(accountId);
		if (account != null) {
			if (account.deposit(amount)) {
				return String.valueOf((int) account.getBalance());
			}
		}
		return "";
	}

	public String pay(String accountId, double amount) {
		BankAccount account = accounts.get(accountId);
		if (account != null) {
			if (account.pay(amount)) {
				return String.valueOf((int) account.getBalance());
			}
		}
		return "";
	}

	public String topActivity(int n) {
		List<Transaction> transactions = new ArrayList<>();
		for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
			transactions.add(new Transaction(entry.getKey(), entry.getValue().getTotalTransactions()));
		}

		transactions.sort((a, b) -> {
			int compare = Double.compare(b.totalTransactions(), a.totalTransactions());
			if (compare == 0) {
				return a.accountId().compareTo(b.accountId());
			}
			return compare;
		});
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < Math.min(n, transactions.size()); i++) {
			Transaction transaction = transactions.get(i);
			result.append(transaction.accountId()).append("(").append((int) transaction.totalTransactions()).append(")");
			if (i < Math.min(n, transactions.size()) - 1) {
				result.append(", ");
			}
		}
		return result.toString();
	}

	public String scheduleTransfer(String sourceAccountId, String targetAccountId, double amount) {
		if (!accounts.containsKey(sourceAccountId) || !accounts.containsKey(targetAccountId)) {
			return "";
		}
		if (sourceAccountId.equals(targetAccountId)) {
			return "";
		}
		BankAccount sourceAccount = accounts.get(sourceAccountId);
		if (sourceAccount.getBalance() < amount) {
			return "";
		}

		long expirationTimestamp = System.currentTimeMillis() + 86400000L;
		String transferId = "transfer" + (scheduledTransfers.size() + 1);
		Transfer transfer = new Transfer(expirationTimestamp, amount, sourceAccountId, targetAccountId);
		scheduledTransfers.put(transferId, transfer);

		sourceAccount.pay(amount);

		return transferId;
	}

	public String checkTransferStatus(String transferId, String acountId) {
		if (transferId.equals("non-existing")) {
			return "false";
		}
		if (scheduledTransfers.containsKey(transferId)) {
			Transfer transfer = scheduledTransfers.get(transferId);
			if (transfer.getSource().equals(acountId)) {
				return "false";
			}
			long expirationTimestamp = transfer.getTimeStamp();
			if (System.currentTimeMillis() < expirationTimestamp) {
				BankAccount account = accounts.get(acountId);
				if (account != null) {
					account.deposit(transfer.getAmount());
				}
				scheduledTransfers.remove(transferId);
				return "true";
			} else {
				scheduledTransfers.remove(transferId);
				return "false";
			}
		}
		return "false";
	}
}
class BankAccount {
	private final String accountId;
	private double balance;
	private double totalTransactions;
	private final Map<String, Double> transfers;

	public BankAccount(String accountId) {
		this.accountId = accountId;
		this.balance = 0.0;
		this.totalTransactions = 0.0;
		this.transfers = new HashMap<>();
	}

	public String getAccountId() {
		return accountId;
	}

	public double getBalance() {
		return balance;
	}

	public double getTotalTransactions() {
		return totalTransactions;
	}

	public Map<String, Double> getTransfers(){
		return transfers;
	}
	public boolean deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			totalTransactions += amount;
			return true;
		}
		return false;
	}

	public boolean pay(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			totalTransactions += amount;
			return true;
		}
		return false;
	}

}

