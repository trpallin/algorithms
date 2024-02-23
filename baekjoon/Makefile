CXX=g++

CXXFLAGS=-std=c++20 -Wall

SRC_EXT=.cpp

all:
	@echo "Specify a target file name (without extension) as parameter"

%: %$(SRC_EXT)
	$(CXX) $(CXXFLAGS) $< -o $@

clean:
	rm -f *.o
