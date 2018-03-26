function truncateText(element, maxLength) {
    let truncated = element.innerText;

    if (truncated.length > maxLength) {
        truncated = truncated.substr(0,maxLength) + '...';
    }
    return truncated;
}

function truncateAllParagraphs() {
    let paragraphs = document.querySelectorAll('p');

    paragraphs.forEach(function(paragraph) {
        paragraph.innerText = truncateText(paragraph, 400);
    });
}