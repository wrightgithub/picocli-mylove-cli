mvn clean compile
mvn -DskipTests clean package native-image:native-image
upx -7 -k target/mylove-cli