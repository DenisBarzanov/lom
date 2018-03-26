function randomChoice(arr) {
    return arr[Math.floor(Math.random() * arr.length)];
}

function styleArticles() {
    let articles = document.getElementsByClassName('style1');
    for (let i = 0; i < articles.length; i+=2) {
        let article = articles[i];
        let nextArticle = articles[i + 1];
        article.classList.remove('style1');


        let newStyle = 'style' + randomChoice([1, 2, 3]);
        article.classList.add(newStyle);

        if (!nextArticle) break;

        nextArticle.classList.remove('style1');
        nextArticle.classList.add(newStyle);

        nextArticle.classList.add('invert');
        nextArticle.classList.add('alt');
    }
}

window.onload = function() {
    styleArticles();
    truncateAllParagraphs();
};
