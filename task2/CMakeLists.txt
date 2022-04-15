cmake_minimum_required(VERSION 3.1)
project(FirstCMake)

set(CMAKE_CXX_STANDART 11)


find_package(GTest REQUIRED)
enable_testing()


set(SOURCE_LIB ${PROJECT_SOURCE_DIR}/B)
set(INDEX_PATH ${PROJECT_SOURCE_DIR}/A/index.h)
set(SCRIPT_PATH ${PROJECT_SOURCE_DIR}/A/preparing.py)
set(EXECUTABLE_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/bin)
set(LIBRARY_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/lib)


add_custom_target( 
	Generator ALL
	COMMAND python3 ${SCRIPT_PATH} ${INDEX_PATH} 12345
	BYPRODUCTS index.h
)

add_subdirectory(${SOURCE_LIB} ${SOURCE_LIB})

add_executable(CTest ${PROJECT_SOURCE_DIR}/C/main_test.cpp)
add_executable(C ${PROJECT_SOURCE_DIR}/C/main.cpp)

add_dependencies(C Generator)
add_dependencies(CTest Generator)


target_include_directories(C PUBLIC ${PROJECT_SOURCE_DIR})
target_include_directories(CTest PRIVATE ${PROJECT_SOURCE_DIR} PRIVATE ${GTEST_INCLUDE_DIRS})

 
target_link_libraries(C PUBLIC MyLib)
target_link_libraries(CTest PRIVATE ${GTEST_BOTH_LIBRARIES} MyLib)

add_test(CTest "./CTest")



