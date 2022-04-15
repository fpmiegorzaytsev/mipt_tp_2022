#include "A/index.h"
#include "B/lib.h"
#include <gtest/gtest.h>

struct SomeClassTest : public ::testing::Test {
	protected:
		SomeClass object;
		void SetUp() override{
			object.Set(100);
		}
};


TEST_F(SomeClassTest, ClassWorksExcellent){
	ASSERT_EQ(100, object.Get());
}


TEST(index, ArrayGeneratedCorrectly){
	for (int i = 0; i < 5; ++i)
	{
		ASSERT_EQ(i + 1, array[i]);
	}
}