# 🔧 JNIDemo — Android JNI Lab

Application Android démontrant la communication entre Java et du code natif C++ via JNI (Java Native Interface).

## 🎥 Démonstration

[![Demo JNIDemo](https://img.youtube.com/vi/GzJKBDMxF6M/0.jpg)](https://youtu.be/GzJKBDMxF6M)

---

## 📱 Ce que fait l'application

L'application appelle 4 fonctions natives écrites en C++ depuis Java :

| Fonction | Description | Résultat |
|---|---|---|
| `helloFromJNI()` | Retourne un message depuis C++ | `Hello from C++ via JNI !` |
| `factorial(10)` | Calcule un factoriel en natif | `3628800` |
| `reverseString("JNI is powerful!")` | Inverse une chaîne | `!lufrewop si INJ` |
| `sumArray({10,20,30,40,50})` | Somme un tableau | `150` |

---

## 🏗️ Architecture

```
Java (MainActivity)
        ↓  appelle une méthode native
JNI (traducteur)
        ↓  transmet à
C++ (native-lib.cpp)
        ↓  calcule et retourne le résultat
Java affiche le résultat
```

---

## 📁 Structure du projet

```
app/
└── src/
    └── main/
        ├── cpp/
        │   ├── native-lib.cpp     # Code natif C++
        │   └── CMakeLists.txt     # Configuration de compilation
        ├── java/com/example/jnidemo/
        │   └── MainActivity.java  # Appels JNI depuis Java
        └── res/layout/
            └── activity_main.xml  # Interface utilisateur
```

---

## 🛠️ Technologies utilisées

- **Java** — Logique principale et interface
- **C++** — Calculs natifs
- **JNI** — Pont Java ↔ C++
- **NDK** — Kit de développement natif Android
- **CMake** — Compilation du code C++

---

## ⚙️ Prérequis

- Android Studio
- NDK (Side by side)
- CMake
- LLDB
- API minimum : 28

---

## 🚀 Lancer le projet

1. Cloner le dépôt
```bash
git clone https://github.com/fatima-ezzahra-kasraoui/lab22
```
2. Ouvrir dans Android Studio
3. Lancer Gradle Sync
4. Exécuter sur un émulateur ou appareil réel

---

## 📋 Points clés JNI

- Le mot-clé `native` en Java indique que la méthode est implémentée en C++
- `System.loadLibrary("native-lib")` charge le fichier `libnative-lib.so` compilé
- Le nom de chaque fonction C++ suit la convention : `Java_packageName_ClassName_methodName`
- Toute ressource JNI (`GetStringUTFChars`, `GetIntArrayElements`) doit être libérée après usage

---

## 🪵 Logs natifs

Les logs natifs sont visibles dans **Logcat** avec le tag `JNI_DEMO` :

```
I  Appel de helloFromJNI depuis le natif
I  Factoriel de 10 calcule en natif = 3628800
I  String inversee = !lufrewop si INJ
I  Somme du tableau = 150
```
