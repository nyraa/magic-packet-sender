all:
	javac -d ./ ./*.java
compress:
	jar -cvfe ./wakeonlan.jar wakeonlan *.class
clean:
	rm -rf *.class