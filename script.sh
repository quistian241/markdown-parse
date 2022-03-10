
for file in test-files/*.md;
do
  echo -n -e  "${file##*/}\t"
  java MarkdownParse $file
done
