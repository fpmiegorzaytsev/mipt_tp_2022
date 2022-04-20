cmake_minimum_required(VERSION 3.1)
project(MyLib)

set(SOURCE_LIB lib.cpp)

add_library(MyLib SHARED ${SOURCE_LIB})


