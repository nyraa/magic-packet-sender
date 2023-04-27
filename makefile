all:
	mkdir -p bin
	javac -d ./bin ./src/*.java
compress:
	jar -cvfe ./wakeonlan.jar wakeonlan -C ./bin .
clean:
	rm -rf bin