/**
 * Dependency file. It lists all the dependencies used in the application.
 * All dependencies are divided into logical and represent a pair
 * @param objectName The original or semantic name of the dependencies
 *
 * In object:
 * @param version Version of the library used
 * @param dependency Provided dependency
 */
object Dependencies {
    object AndroidComponents {
        private const val ktxCoreVersion = "1.9.0"
        private const val appCompatVersion = "1.5.1"
        private const val materialVersion = "1.7.0"

        const val ktxCore = "androidx.core:core-ktx:$ktxCoreVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val material = "com.google.android.material:material:$materialVersion"
    }

    object TestDependencies {
        private const val jUnitVersion = "4.13.2"
        private const val jUnitExtVersion = "1.1.3"
        private const val espressoCore = "3.4.0"

        //testImplementation
        const val jUnit = "junit:junit:$jUnitVersion"

        //androidTestImplementation
        const val jUnitExt = "androidx.test.ext:junit:$jUnitExtVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoCore"
    }

    object Navigation {
        private const val navigationVersion = "2.5.3"

        const val navigation = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    }

    object AdapterDelegates {
        private const val adapterVersion = "4.3.2"

        const val adapterDelegates =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:$adapterVersion"
        const val adapterDelegatesViewBinding =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:$adapterVersion"
    }

    object Modules {
        private const val uiModule = "moduleUI"

        const val UI = ":$uiModule"
    }

    object Koin {
        private const val koinVersion = "3.2.2"

        const val koinCore = "io.insert-koin:koin-core:$koinVersion"
        const val koinAndroid = "io.insert-koin:koin-android:$koinVersion"
    }
}