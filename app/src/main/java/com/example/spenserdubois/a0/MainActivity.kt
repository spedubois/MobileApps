package com.example.spenserdubois.a0

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Phrase(phrase: String){

    val split: List<String> = phrase.split(" ")

}


class MainActivity : AppCompatActivity() {

    fun checkUpper(word: String): Int{

        val deWord: String = word.toLowerCase()

        if(deWord.equals(word)) return 0 else return 1
    }

    fun checkLetters(word: String): Int{

        val wordArray = word.toCharArray()
        val numReg = Regex(pattern = "\\d")
        val puncReg = Regex(pattern = "\\W")

        if(numReg.containsMatchIn(input = word))
            return 0
        if(puncReg.containsMatchIn(input = word))
            return 0

        return 1

    }

    fun isEven(word: String): Int{
        if(word.length % 2 == 0) return 1 else return 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input: String = "anotHers Using Kotlin for Android Development Kotlin is a  " +
                "anotHers great fit for developingAndroid applications, bringing all of the advantages of   " +
                "a modern language to the Android platform without introducing any new restrictions: " +
                "Compatibility: Kotlin is   fully compatible with JDK 6, ensuring that Kotlin applications can run on   " +
                "older Android devices with no issues. The Kotlin tooling is fully supported in   " +
                "Android Studio and compatible with the Android build system. " +
                "Performance: A  Kotlin application runs as fast as an equivalent Java one, anotHers thanks to   " +
                "very similar bytecode structure. WithKotlin's support for inline functions, " +
                "code using lambdas often runs evenfaster than the same code written in   " +
                "Java. Interoperability: Kotlin is 100% interoperable with Java, allowing to   " +
                "use all existing Android libraries in   " +
                "a Kotlin application. This includes annotation processing, so databinding and Dagger work too. " +
                "Footprint: Kotlin has a very compactruntime library, which can be   " +
                "further reduced through the use of ProGuard. In a  real application, the Kotlin runtime adds only a  " +
                "few hundred methods and less than 100K to   " +
                "the size of   the .apk file. Compilation Time: Kotlin supports efficient incremental compilation, " +
                "so while there's some additional overhead for clean builds, incremental builds are usually as fast or   " +
                "faster than with Java. Learning Curve: For a Java developer,getting started with Kotlin is   " +
                "very easy. The automated Java to Kotlin converter included in   " +
                "the Kotlin plugin helps with the first steps. Kotlin Koans offer a  " +
                "guide through the key features of the language with a  series of interactive exercises. " +
                "Kotlin for Android Case Studies Kotlin has been successfully adopted by   major companies, and a   " +
                "few of them have shared their experiences: ThisTest Pinterest has successfully introduced Kotlin into theirapplication, used by   " +
                "150M people every month. Basecamp's Android app is 100% Kotlin code, and they report a huge difference in  " +
                " programmer happiness and great improvements in   work quality and speed. Keepsafe's App Lock app has also been converted to " +
                "  100% Kotlin, leading to a  30% decrease in source line count and 10% decrease in method count. " +
                "Tools for Android Development The Kotlin team offers a  set of tools for Android development " +
                "that goes beyond the standard language features: Kotlin Android Extensionsis a  compiler extension that allows you to  " +
                " get rid of findViewById() callsin your code and to replace them with synthetic compiler-generated properties. Anko is a " +
                " library providing a  set of   Kotlin-friendly wrappers around the Android APIs, as   well as " +
                "  a  DSL that lets your anotHers replace your layout .xml files with Kotlin code. " +
                "Next Steps Download an install Android Studio 3.0 Preview, which includes Kotlin support out of the box. " +
                "Follow the Getting Started with Android ThisTest and Kotlin tutorial to   create your first Kotlin application. For a  " +
                "more in-depth introduction, check out the reference documentation on   this site and Kotlin Koans. " +
                "Another greatresource is   Kotlin for Android Developers, a book that guides you step by step through the process of " +
                "  creating a real Android application in   Kotlin. Check anotHers out Google's sample projects written in Kotlin."


        val words = object{
            var foundWords: HashSet<String> = HashSet<String>()
            var longest: String = "";
        }

        val p: Phrase = Phrase(input)
        for(i in 0..p.split.size-1){
            var checks = IntArray(3)
            checks[0] = checkLetters(p.split[i])
            checks[1] = checkUpper(p.split[i])
            checks[2] = isEven(p.split[i])

            val total: Int = checks.reduce{sum, element -> sum + element}
            if(total == 3){
                if(!words.foundWords.contains(p.split[i])) {
                    words.foundWords.add(p.split[i])
                    continue
                }
                else if(words.foundWords.contains(p.split[i])){
                    if(p.split[i].length > words.longest.length)
                        words.longest = p.split[i]
                    if(p.split[i].length == words.longest.length){
                        val fWord = p.split[i].toLowerCase().toCharArray()
                        val lWord = words.longest.toLowerCase().toCharArray()
                        if(fWord[0] < lWord[0])
                            words.longest=p.split[i]
                    }
                }

            }

        }

        Log.e("MainActivity", ""+words.longest)
    }
}
