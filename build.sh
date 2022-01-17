mvn clean compile
mvn -DskipTests clean package native-image:native-image

if [[ "$1" =~ "-o" ]];
then
  echo "upx run with $1 $2"
  rm $2
  upx -7 -k target/mylove-cli $1 $2
else
  echo "upx run without -o"
  upx -7 -k target/mylove-cli
fi





