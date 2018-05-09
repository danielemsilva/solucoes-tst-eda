element = int(input())
array = input().split(" ")
indexes = ""

for i in range (len(array)):
  if int(array[i]) == element:
    if (len(indexes) != 0):
      indexes += " ";
    indexes += str(i);

if (len(indexes) == 0):
  indexes = "-1"
print (indexes)
