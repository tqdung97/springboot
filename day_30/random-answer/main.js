const quizes = [
    {
        id: 1,
        question: "1 + 1 = ?",
        answers: [1, 2, 3, 4],
    },
    {
        id: 2,
        question: "2 + 2 = ?",
        answers: [2, 3, 4, 5],
    },
    {
        id: 3,
        question: "3 + 3 = ?",
        answers: [3, 4, 5, 6],
    },
];

const quizContainerEl = document.querySelector(".quiz-container");
const btn = document.getElementById("btn")

const renderQuizes = arr => {
    quizContainerEl.innerHTML = "";
    let html = "";
    arr.forEach((quiz, index) => {
        html += `
            <div class="quiz-item">
                <h3>Câu ${index + 1} : ${quiz.question}</h3>
                <div class="quiz-answer">
                    ${generateQuizAnswer(quiz.answers, quiz.id)}
                </div>
            </div>
        `
    });

    quizContainerEl.innerHTML = html;
}

const generateQuizAnswer = (arr, id) => {
    let html = "";
    arr.forEach(answer => {
        html += `
            <div class="quiz-answer-item">
                <input type="radio" name=${id}>
                <label>${answer}</label>
            </div>
        `
    })
    return html;
}

btn.addEventListener("click", () => {
    const listQuizEl = document.querySelectorAll(".quiz-item");
    listQuizEl.forEach(quiz => {
        const listQuizItemEl = quiz.querySelectorAll("input");
        const rdIndex = Math.floor(Math.random() * listQuizItemEl.length);
        listQuizItemEl[rdIndex].checked = true;
    })
})

renderQuizes(quizes);
