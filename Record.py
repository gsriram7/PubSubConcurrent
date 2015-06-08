import sys
import commands

l = commands.getoutput("wc -l intellij_console.log && egrep 'Pub|Sub|Tot' intellij_console.log")
f = open('output.txt', 'a')

op = l.split(" ")

data = op[6].split("\n")[0]+"\t"+op[11].split("\n")[0]+"\t"+op[12]+"\n"
print data

if op[0] == sys.argv[1]:	f.write(data)
f.close()
