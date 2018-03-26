function formatParagraphAll() {
    let paragraphs = document.querySelectorAll('p');
    paragraphs.forEach(function(paragraph) {
        paragraph.style.whiteSpace='pre-line';
    });
}

window.onload = function() {
    formatParagraphAll();
};
