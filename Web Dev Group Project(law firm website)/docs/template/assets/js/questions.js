// Define the quiz questions and options
var questions = [
    {
      question: "What is the capital of France?",
      options: ["London", "Paris", "Berlin", "Madrid"],
      answer: "Paris"
    },
    {
      question: "What is the highest mountain in the world?",
      options: ["Mount Everest", "Mount Kilimanjaro", "Mount Fuji", "Mount McKinley"],
      answer: "Mount Everest"
    },
    {
      question: "What is the currency of Japan?",
      options: ["Yen", "Dollar", "Peso", "Euro"],
      answer: "Yen"
    }
  ];
  
  // Define variables to keep track of the quiz state
  var currentQuestionIndex = 0;
  var score = 0;
  var timeLeft = 30;
  var timerIntervalId;
  
  // Get references to DOM elements
  var startQuizBtn = document.getElementById("start-quiz-btn");
  var quizOverlay = document.getElementById("quiz-overlay");
  var questionEl = document.getElementById("question");
  var optionsEl = document.getElementById("options");
  var submitBtn = document.getElementById("submit-btn");
  var scoreEl = document.getElementById("score");
  var restartBtn = document.getElementById("restart-btn");
  var timerEl = document.getElementById("timer");
  
  // Start quiz when user clicks start button
  startQuizBtn.addEventListener("click", function() {
    startQuiz();
  });
  
  // Start quiz function
  function startQuiz() {
    // Hide start button and show quiz overlay
    startQuizBtn.style.display = "none";
    quizOverlay.style.display = "block";
    
    // Start the timer
    startTimer();
  
    // Show the first question
    showQuestion();
  }
  
  // Show the current question and options
  function showQuestion() {
    // Get the current question
    var currentQuestion = questions[currentQuestionIndex];
  
    // Set the question text
    questionEl.textContent = currentQuestion.question;
  
    // Clear the options
    optionsEl.innerHTML = "";
  
    // Add the options as buttons
    for (var i = 0; i < currentQuestion.options.length; i++) {
      var option = currentQuestion.options[i];
      var optionBtn = document.createElement("button");
      optionBtn.textContent = option;
      optionsEl.appendChild(optionBtn);
    }
  
    // Add click event listeners to options buttons
    optionsEl.querySelectorAll("button").forEach(function(optionBtn) {
      optionBtn.addEventListener("click", function() {
        // Check if the user's answer is correct
        var selectedAnswer = optionBtn.textContent;
        if (selectedAnswer === currentQuestion.answer) {
          score++;
        }
  
        // Move on to the next question or end the quiz if all questions have been answered
        currentQuestionIndex++;
        if (currentQuestionIndex === questions.length) {
          endQuiz();
        } else {
          showQuestion();
        }
      });
    });
  }
  
  // Start the timer
  function startTimer() {
    // Set the initial time left
    timeLeft = 30;
  
    // Update the timer element every second
    timerIntervalId = setInterval(function() {
      // Decrease the time left by one second
      timeLeft--;
  
      // Update the timer element
      timerEl.textContent = "Time left: " + timeLeft;
  
      // End the quiz if time runs out
      if (timeLeft === 0) {
        endQuiz();
      }
    }, 1000);
  }
  
  // End the quiz and display the score
  function endQuiz() {
    // Stop the timer
    clearInterval(timerIntervalId);
  
  // Hide the quiz overlay and show the score overlay
  quizOverlay.style.display = "none";
  scoreEl.textContent = "You scored " + score + " out of " + questions.length;
  scoreOverlay.style.display = "block";
}

// Restart the quiz when user clicks restart button
restartBtn.addEventListener("click", function() {
  // Reset quiz state variables
  currentQuestionIndex = 0;
  score = 0;
  timeLeft = 30;

  // Hide the score overlay and show the quiz overlay
  scoreOverlay.style.display = "none";
  quizOverlay.style.display = "block";

  // Start the quiz again
  startQuiz();
});
  