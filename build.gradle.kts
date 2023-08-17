
buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.5.3"
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false

}