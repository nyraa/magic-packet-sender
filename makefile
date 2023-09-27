all:
	mkdir -p bin
	javac -d ./bin ./src/*.java
run:
	java -cp ./bin wakeonlan
compress:
	jar -cvfe ./wakeonlan.jar wakeonlan -C ./bin .
clean:
	rm -rf bin