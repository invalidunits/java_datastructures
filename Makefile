%.class: %.java
	javac $<

%: datastructures/Lecture%.class
	java datastructures.Lecture$@

.PHONY: clean

clean: 
	rm datastructures/*.class

