cmake_minimum_required(VERSION 3.0)

set(CMAKE_C_COMPILER ${TOOLCHAIN}/aarch64-linux-gnu-gcc)
set(CMAKE_CXX_COMPILER ${TOOLCHAIN}/aarch64-linux-gnu-g++)
project(SimpleLibrary)

include_directories(include)

set(CMAKE_INSTALL_RPATH  ${CMAKE_INSTALL_PREFIX}/lib)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${SimpleLibrary_SOURCE_DIR}/bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${SimpleLibrary_SOURCE_DIR}/lib)
add_subdirectory(src)
add_executable(MainLib main_lib.cpp)
add_executable(Main main.cpp)

target_link_libraries(MainLib buffer)

install(FILES include/buffer.h
        DESTINATION ${CMAKE_INSTALL_PREFIX}/include)

install(TARGETS MainLib Main
        RUNTIME DESTINATION ${CMAKE_INSTALL_PREFIX}/bin)
