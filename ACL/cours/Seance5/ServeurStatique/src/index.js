import { readFile, stat, readdir } from "fs/promises";
import { createServer } from "http";
import path from "path";

const server = createServer(async (req, res) => {
    console.log("Requete GET");
    console.log(req.url);

    const publicDir = path.resolve("../public");
    const urlPath = decodeURIComponent(req.url);
    const filePath = path.join(publicDir, urlPath);

    try {
        const stats = await stat(filePath);
        if (stats.isDirectory()) {
            const files = await readdir(filePath);
            let html = `<h1>Index de ${req.url}</h1>`;
            // Lien vers le dossier parent
            if (req.url !== "/") {
                const parent = path.posix.dirname(req.url);
                html += `<a href="${parent === "." ? "/" : parent}">../</a><br>`;
            }
            // Liste des fichiers et dossiers
            for (const file of files) {
                const fileUrl = path.posix.join(req.url, file);
                html += `<a href="${fileUrl}">${file}</a><br>`;
            }
            res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
            res.end(html);
        } else {
            // C'est un fichier : on l'envoie
            const data = await readFile(filePath);
            res.writeHead(200, { 'Content-Type': 'application/octet-stream' });
            res.end(data);
        }
    } catch (err) {
        res.writeHead(404, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(`<h1> Chemin ${req.url}</h1><h2> Fichier ou dossier non trouvé</h2>`);
    }
});
server.listen(8500, () => console.log("Serveur Listening"));

