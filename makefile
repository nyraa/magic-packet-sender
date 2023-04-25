all:
	javac -d ./ ./*.java
compress:
	make all
	jar -cvfe ./wakeonlan.jar wakeonlan *.class
clean:
	rm -rf *.class