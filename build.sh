#!/bin/bash
# -*- coding: UTF-8 -*-

# === Chemins ===
SRC="src/main/java/app"
WEBAPP="src/main/webapp"
RESOURCES="src/main/resources"
OUT="build"
LIB="lib"
FRAMEWORK="../myframework/dist/myframework.jar"

# === Création du dossier de sortie ===
mkdir -p "$OUT"

# === Construction de la liste des fichiers Java ===
echo "📜 Création de la liste des sources Java..."
find "$SRC" -name "*.java" > sources.txt

# === Compilation ===
echo "🧱 Compilation des fichiers Java..."
javac -encoding UTF-8 -source 17 -target 17 -cp "$LIB/*:$FRAMEWORK" -d "$OUT/WEB-INF/classes" @"sources.txt"

if [ $? -ne 0 ]; then
    echo "❌ Erreur de compilation."
    exit 1
fi

echo "✅ Compilation réussie."

# === Copie des ressources web ===
echo "📁 Copie des fichiers web..."
cp -r "$WEBAPP"/* "$OUT"/

# === Copie des fichiers de ressources ===
echo "📦 Copie des fichiers de ressources..."
if [ -d "$RESOURCES" ]; then
    mkdir -p "$OUT/WEB-INF/classes"
    cp -r "$RESOURCES"/* "$OUT/WEB-INF/classes/"
else
    echo "⚠️  Attention : le dossier de ressources $RESOURCES n'existe pas !"
fi

# === Copie des libs dans WEB-INF/lib ===
echo "📚 Copie des bibliothèques..."
mkdir -p "$OUT/WEB-INF/lib"
cp -f "$LIB"/*.jar "$OUT/WEB-INF/lib/" 2>/dev/null || echo "⚠️  Aucune librairie trouvée dans $LIB"

# === Copie du framework ===
echo "🔧 Copie du framework..."
if [ -f "$FRAMEWORK" ]; then
    cp -f "$FRAMEWORK" "$OUT/WEB-INF/lib/"
else
    echo "⚠️  Attention : le framework $FRAMEWORK est introuvable !"
fi

# === Création du fichier WAR ===
echo "📦 Création du WAR..."
cd "$OUT" || exit 1
jar -cvf ../Sprint.war *
cd ..

echo "✅ === WAR généré avec succès : Sprint.war ==="
