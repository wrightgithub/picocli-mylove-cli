export GRAAL_HOME := "~/.jenv/candidates/java/graalvm-20.3.0-java11"

# native build
native_build:
    # 编译native image
   mvn -DskipTests clean package native-image:native-image
    # 使用upx 压缩 native image  -7代表压缩程度的等级，数字越大，压缩的越小
   upx -7 -k target/demo-cli

# shell completion
shell-completion:
   mvn compile exec:exec

# run with agent
run_with_agent:
   mkdir -p target/native-image
   {{GRAAL_HOME}}/bin/java -agentlib:native-image-agent=config-output-dir=target/native-image -jar target/demo-cli.jar demo

# run test
test:
   ./target/demo-cli Jackie

# setup
setup:
   brew install upx
