import java.net.URI

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }

    dependencies {
        classpath(kotlin(module = "gradle-plugin", version = Versions.kotlin))
        classpath(BuildPlugins.androidPlugin)
        classpath(BuildPlugins.navigationSafe)
        classpath(BuildPlugins.realm)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = URI.create(Url.jitpack)
        }
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}