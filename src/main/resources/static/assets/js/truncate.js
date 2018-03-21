function truncateText(selector, maxLength) {
    let element = document.querySelector(selector),
        truncated = element.innerText;

    if (truncated.length > maxLength) {
        truncated = truncated.substr(0,maxLength) + '...';
    }
    return truncated;
}

//document.querySelector('p').innerText = truncateText('p', 110);
function truncateAllParagraphs() {
    let paragraphs = document.querySelectorAll('p');

    paragraphs.forEach(function(paragraph) {
        paragraph.innerText = truncateText('p', 500);
    });
}