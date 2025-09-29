#!/bin/bash
# -*- coding: UTF-8 -*-

# === Variables ===
WAR_NAME="Sprint.war"
SOURCE_DIR="."  # dossier actuel, tu peux changer si besoin
DEST_DIR="/opt/tomcat/webapps"  # 🛠️ adapte ce chemin à ton installation Tomcat

echo "🚀 Déploiement de $WAR_NAME vers $DEST_DIR ..."

# === Copie du fichier WAR ===
cp -f "$SOURCE_DIR/$WAR_NAME" "$DEST_DIR/$WAR_NAME"

# === Vérification ===
if [ $? -eq 0 ]; then
    echo "✅ Déploiement réussi."
else
    echo "❌ Échec du déploiement."
    exit 1
fi
