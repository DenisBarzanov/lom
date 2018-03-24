package org.lomhospital.medicine

import org.junit.Test
import org.junit.runner.RunWith
import org.lomhospital.medicine.util.imageUrlList
import org.lomhospital.medicine.util.splitInto
import org.lomhospital.medicine.util.toUrlString
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class MedicineApplicationTests {

	@Test
	fun contextLoads() {
	}

}

@RunWith(SpringRunner::class)
@SpringBootTest
class UtilTests {

	@Test
	fun convertsFromUrlStringToUrlList() {
		val urls = "http:blablabla\r\nhttp:blablkjdhfdjfasdfjasabla"
		val urlList = imageUrlList(urls)
		assert(urlList == listOf("http:blablabla", "http:blablkjdhfdjfasdfjasabla"))
	}
	
	@Test
	fun splitsStringIntoEqualParts() {
		val string = "0123456789"
		val split = string splitInto 4
		assert(split == listOf("012", "345", "678", "9"), fun()="$split")
	}

	@Test
	fun convertsFromUrlListToUrlString() {
		val urlList = listOf("http:blablabla", "http:blablkjdhfdjfasdfjasabla")
		val string = urlList.toUrlString()
		assert(string == "http:blablabla\r\nhttp:blablkjdhfdjfasdfjasabla", fun()= string)
	}
}