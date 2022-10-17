n=input()
out=""
for i in n:
    if i!='0':
        out+=i
    if i == '0':
        continue
print(out[0]+'.'+out[1:3]+ " * 10^"+str(len(n)-1))
    
