add_library(buffer SHARED buffer.cpp)
install(TARGETS buffer
        LIBRARY DESTINATION ${CMAKE_INSTALL_PREFIX}/lib)