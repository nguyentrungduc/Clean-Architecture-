plugins {
    id(GradlePlugins.javaLib)
    id(GradlePlugins.kotlin)
}

dependencies {
    // kotlin core
    implementation(Libs.stdLib)
    implementation(Libs.ktx)

    // rx
    implementation(Libs.rxJava)
    implementation(Libs.rxAndroid)

    // dagger
    implementation(Libs.daggerAndroid)
    implementation(Libs.daggerSupport)

}
