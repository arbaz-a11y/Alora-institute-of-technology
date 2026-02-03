let selectedCourse = '';
let currentStudent = '';
let selectedTest = '';

// Student database
const studentsData = {
    'DCET': {
        '100': { 
            name: 'Arbaz', 
            test1: { marks: { 'FEEE': 9, 'Maths': 9, 'PMS': 14, 'Statistics': 14, 'IT': 15 } },
            test2: { marks: { 'FEEE': 10, 'Maths': 11, 'PMS': 13, 'Statistics': 15, 'IT': 14 } }
        },
        '101': { 
            name: 'Vinod', 
            test1: { marks: { 'FEEE': 10, 'Maths': 11, 'PMS': 13, 'Statistics': 14, 'IT': 14 } },
            test2: { marks: { 'FEEE': 11, 'Maths': 12, 'PMS': 14, 'Statistics': 13, 'IT': 15 } }
        },
        '102': { 
            name: 'Abhishek', 
            test1: { marks: { 'FEEE': 12, 'Maths': 10, 'PMS': 15, 'Statistics': 13, 'IT': 14 } },
            test2: { marks: { 'FEEE': 13, 'Maths': 11, 'PMS': 14, 'Statistics': 14, 'IT': 15 } }
        },
        '103': { 
            name: 'Poorvi', 
            test1: { marks: { 'FEEE': 11, 'Maths': 12, 'PMS': 14, 'Statistics': 15, 'IT': 13 } },
            test2: { marks: { 'FEEE': 12, 'Maths': 13, 'PMS': 15, 'Statistics': 14, 'IT': 14 } }
        },
        '104': { 
            name: 'Priya', 
            test1: { marks: { 'FEEE': 13, 'Maths': 11, 'PMS': 14, 'Statistics': 14, 'IT': 15 } },
            test2: { marks: { 'FEEE': 14, 'Maths': 12, 'PMS': 15, 'Statistics': 15, 'IT': 14 } }
        },
        '105': { 
            name: 'Vaibhavi', 
            test1: { marks: { 'FEEE': 10, 'Maths': 13, 'PMS': 15, 'Statistics': 14, 'IT': 14 } },
            test2: { marks: { 'FEEE': 11, 'Maths': 14, 'PMS': 14, 'Statistics': 15, 'IT': 15 } }
        },
        '106': { 
            name: 'Siddharth', 
            test1: { marks: { 'FEEE': 14, 'Maths': 12, 'PMS': 13, 'Statistics': 15, 'IT': 14 } },
            test2: { marks: { 'FEEE': 15, 'Maths': 13, 'PMS': 14, 'Statistics': 14, 'IT': 15 } }
        },
        '108': { 
            name: 'Joel', 
            test1: { marks: { 'FEEE': 11, 'Maths': 14, 'PMS': 14, 'Statistics': 13, 'IT': 15 } },
            test2: { marks: { 'FEEE': 12, 'Maths': 15, 'PMS': 15, 'Statistics': 14, 'IT': 14 } }
        },
        '109': { 
            name: 'Varsha', 
            test1: { marks: { 'FEEE': 12, 'Maths': 13, 'PMS': 15, 'Statistics': 14, 'IT': 14 } },
            test2: { marks: { 'FEEE': 13, 'Maths': 14, 'PMS': 14, 'Statistics': 15, 'IT': 15 } }
        },
        '110': { 
            name: 'Sinchana', 
            test1: { marks: { 'FEEE': 13, 'Maths': 14, 'PMS': 14, 'Statistics': 15, 'IT': 15 } },
            test2: { marks: { 'FEEE': 14, 'Maths': 15, 'PMS': 15, 'Statistics': 14, 'IT': 14 } }
        }
    },
    'JEE': {
        '101': { name: 'Shrinidhi', marks: { 'Mathematics': 75, 'Physics': 82, 'Chemistry': 78 } },
        '102': { name: 'Krish', marks: { 'Mathematics': 88, 'Physics': 79, 'Chemistry': 85 } },
        '103': { name: 'Aditya', marks: { 'Mathematics': 68, 'Physics': 72, 'Chemistry': 80 } },
        '104': { name: 'Deepak', marks: { 'Mathematics': 82, 'Physics': 88, 'Chemistry': 76 } },
        '105': { name: 'Tejas', marks: { 'Mathematics': 90, 'Physics': 85, 'Chemistry': 92 } },
        '106': { name: 'Parinita', marks: { 'Mathematics': 76, 'Physics': 80, 'Chemistry': 84 } },
        '107': { name: 'Atharv', marks: { 'Mathematics': 85, 'Physics': 78, 'Chemistry': 88 } },
        '108': { name: 'Chetan', marks: { 'Mathematics': 72, 'Physics': 86, 'Chemistry': 75 } },
        '109': { name: 'Mathan', marks: { 'Mathematics': 80, 'Physics': 83, 'Chemistry': 79 } },
        '110': { name: 'Aaron', marks: { 'Mathematics': 92, 'Physics': 89, 'Chemistry': 91 } }
    },
    'NEET': {
        '100': { name: 'Aarohi', marks: { 'Physics': 145, 'Chemistry': 160, 'Biology': 170 } },
        '101': { name: 'Nitin', marks: { 'Physics': 150, 'Chemistry': 155, 'Biology': 165 } },
        '102': { name: 'Suman', marks: { 'Physics': 135, 'Chemistry': 145, 'Biology': 175 } },
        '103': { name: 'Ritesh', marks: { 'Physics': 155, 'Chemistry': 150, 'Biology': 160 } },
        '104': { name: 'Pallavi', marks: { 'Physics': 160, 'Chemistry': 165, 'Biology': 172 } },
        '105': { name: 'Mohit', marks: { 'Physics': 140, 'Chemistry': 158, 'Biology': 168 } },
        '106': { name: 'Tanvi', marks: { 'Physics': 148, 'Chemistry': 162, 'Biology': 174 } },
        '107': { name: 'Yash', marks: { 'Physics': 152, 'Chemistry': 148, 'Biology': 166 } },
        '108': { name: 'Bhavya', marks: { 'Physics': 158, 'Chemistry': 170, 'Biology': 178 } },
        '109': { name: 'Karthik', marks: { 'Physics': 142, 'Chemistry': 152, 'Biology': 164 } },
        '110': { name: 'Ishaan', marks: { 'Physics': 165, 'Chemistry': 168, 'Biology': 180 } }
    },
    'KCET': {
        '100': { name: 'Sanjay', marks: { 'Physics': 48, 'Chemistry': 52, 'Mathematics': 45, 'Biology': 55 } },
        '101': { name: 'Mehul', marks: { 'Physics': 50, 'Chemistry': 48, 'Mathematics': 47, 'Biology': 53 } },
        '102': { name: 'Aditi', marks: { 'Physics': 52, 'Chemistry': 55, 'Mathematics': 50, 'Biology': 57 } },
        '103': { name: 'Pranav', marks: { 'Physics': 46, 'Chemistry': 50, 'Mathematics': 48, 'Biology': 52 } },
        '104': { name: 'Nandini', marks: { 'Physics': 54, 'Chemistry': 53, 'Mathematics': 52, 'Biology': 56 } },
        '105': { name: 'Suresh', marks: { 'Physics': 49, 'Chemistry': 51, 'Mathematics': 46, 'Biology': 54 } },
        '106': { name: 'Riya', marks: { 'Physics': 55, 'Chemistry': 54, 'Mathematics': 53, 'Biology': 58 } },
        '107': { name: 'Harsh', marks: { 'Physics': 47, 'Chemistry': 49, 'Mathematics': 44, 'Biology': 51 } },
        '108': { name: 'Keerthi', marks: { 'Physics': 53, 'Chemistry': 56, 'Mathematics': 51, 'Biology': 57 } },
        '109': { name: 'Lokesh', marks: { 'Physics': 51, 'Chemistry': 52, 'Mathematics': 49, 'Biology': 55 } },
        '110': { name: 'Anirudh', marks: { 'Physics': 56, 'Chemistry': 57, 'Mathematics': 54, 'Biology': 59 } }
    },
    'Foundation': {
        '101': { name: 'Student 1', marks: { 'Mathematics': 75, 'Science': 80, 'English': 85 } },
        '102': { name: 'Student 2', marks: { 'Mathematics': 80, 'Science': 75, 'English': 78 } },
        '103': { name: 'Student 3', marks: { 'Mathematics': 85, 'Science': 82, 'English': 80 } }
    }
};

function showPage(pageName) {
    const pages = document.querySelectorAll('.page');
    pages.forEach(page => page.classList.remove('active'));
    document.getElementById(pageName).classList.add('active');
    
    // If navigating away from courses, reset course details
    if (pageName !== 'courses') {
        const courseDetails = document.querySelectorAll('.course-details');
        courseDetails.forEach(detail => detail.classList.remove('active'));
        document.getElementById('coursesGrid').style.display = 'grid';
    }
    
    // Scroll to top
    window.scrollTo({ top: 0, behavior: 'smooth' });
}

function showCourseDetails(courseName) {
    // Hide courses grid
    document.getElementById('coursesGrid').style.display = 'none';
    
    // Hide all course details
    const allDetails = document.querySelectorAll('.course-details');
    allDetails.forEach(detail => detail.classList.remove('active'));
    
    // Show selected course details
    document.getElementById(courseName + 'Details').classList.add('active');
}

function backToCourses() {
    // Show courses grid
    document.getElementById('coursesGrid').style.display = 'grid';
    
    // Hide all course details
    const allDetails = document.querySelectorAll('.course-details');
    allDetails.forEach(detail => detail.classList.remove('active'));
    
    // Hide all semester info
    const allSemInfo = document.querySelectorAll('.semester-info');
    allSemInfo.forEach(info => info.classList.remove('active'));
    
    // Reset semester buttons
    const allSemBtns = document.querySelectorAll('.semester-btn');
    allSemBtns.forEach(btn => btn.classList.remove('active'));
}

function showSemesterInfo(semester) {
    // Hide all semester info
    const allInfo = document.querySelectorAll('.semester-info');
    allInfo.forEach(info => info.classList.remove('active'));
    
    // Reset all semester buttons
    const allBtns = document.querySelectorAll('.semester-btn');
    allBtns.forEach(btn => btn.classList.remove('active'));
    
    // Show selected semester info and activate button
    if (semester === 'sem5') {
        document.getElementById('sem5Info').classList.add('active');
        event.target.classList.add('active');
    } else if (semester === 'sem6') {
        document.getElementById('sem6Info').classList.add('active');
        event.target.classList.add('active');
    } else if (semester === 'crash') {
        document.getElementById('crashInfo').classList.add('active');
        event.target.classList.add('active');
    }
}

function toggleChatbot() {
    const chatbot = document.getElementById('chatbotContainer');
    chatbot.classList.toggle('active');
}

function selectCourse(course) {
    selectedCourse = course;
    
    // Update button states
    const buttons = document.querySelectorAll('.course-btn');
    buttons.forEach(btn => btn.classList.remove('active'));
    event.target.classList.add('active');
    
    // Show login form
    document.getElementById('studentLogin').classList.add('active');
    
    // Reset other sections
    document.getElementById('testSelection').classList.remove('active');
    document.getElementById('marksDisplay').classList.remove('active');
    document.getElementById('aiAnalysis').classList.remove('active');
    document.getElementById('rollNumber').value = '';
    document.getElementById('studentName').value = '';
    selectedTest = '';
}

function viewAnalysis() {
    const rollNumber = document.getElementById('rollNumber').value;
    const studentName = document.getElementById('studentName').value.trim();
    
    if (!rollNumber || !studentName) {
        alert('Please enter both roll number and student name');
        return;
    }

    if (!selectedCourse) {
        alert('Please select a course first');
        return;
    }

    // Validate student
    const student = studentsData[selectedCourse][rollNumber];
    
    if (!student) {
        alert('Invalid roll number for this course');
        return;
    }

    if (student.name.toLowerCase() !== studentName.toLowerCase()) {
        alert('Student name does not match the roll number');
        return;
    }

    currentStudent = rollNumber;

    // For DCET, show test selection
    if (selectedCourse === 'DCET') {
        document.getElementById('testSelection').classList.add('active');
        document.getElementById('marksDisplay').classList.remove('active');
        document.getElementById('aiAnalysis').classList.remove('active');
    } else {
        // For other courses, directly show marks
        displayMarks();
    }
}

function selectTest(test) {
    selectedTest = test;
    
    // Update button states
    const buttons = document.querySelectorAll('.test-btn');
    buttons.forEach(btn => btn.classList.remove('active'));
    event.target.classList.add('active');
    
    // Display marks for selected test
    displayMarks();
}

function displayMarks() {
    const student = studentsData[selectedCourse][currentStudent];
    
    // Show marks display
    document.getElementById('marksDisplay').classList.add('active');
    
    // Get marks based on course and test
    let marks;
    if (selectedCourse === 'DCET') {
        marks = student[selectedTest].marks;
        document.getElementById('marksTitle').textContent = `DCET Marks - ${selectedTest === 'test1' ? 'Test 1' : 'Test 2'}`;
    } else {
        marks = student.marks;
        document.getElementById('marksTitle').textContent = selectedCourse + ' Marks';
    }
    
    // Add document links
    const documentLinks = document.getElementById('documentLinks');
    if (selectedCourse === 'DCET') {
        const testNum = selectedTest === 'test1' ? '1' : '2';
        documentLinks.innerHTML = `
            (<a href="#" class="doc-link" onclick="showDocument('unit-test-${selectedTest}'); return false;">Unit Test ${testNum}</a>
            <span class="link-separator">|</span>
            <a href="#" class="doc-link" onclick="showDocument('omr-${selectedTest}'); return false;">OMR Sheet</a>)
        `;
    } else if (selectedCourse === 'JEE') {
        documentLinks.innerHTML = `
            (<a href="#" class="doc-link" onclick="showDocument('question-paper'); return false;">Question Paper</a>
            <span class="link-separator">|</span>
            <a href="#" class="doc-link" onclick="showDocument('answer-sheet'); return false;">Answer Sheet</a>)
        `;
    } else if (selectedCourse === 'NEET') {
        documentLinks.innerHTML = `
            (<a href="#" class="doc-link" onclick="showDocument('question-paper'); return false;">Question Paper</a>
            <span class="link-separator">|</span>
            <a href="#" class="doc-link" onclick="showDocument('omr'); return false;">OMR Sheet</a>)
        `;
    } else if (selectedCourse === 'KCET') {
        documentLinks.innerHTML = `
            (<a href="#" class="doc-link" onclick="showDocument('question-paper'); return false;">Question Paper</a>
            <span class="link-separator">|</span>
            <a href="#" class="doc-link" onclick="showDocument('omr'); return false;">OMR Sheet</a>)
        `;
    } else if (selectedCourse === 'Foundation') {
        documentLinks.innerHTML = `
            (<a href="#" class="doc-link" onclick="showDocument('question-paper'); return false;">Question Paper</a>
            <span class="link-separator">|</span>
            <a href="#" class="doc-link" onclick="showDocument('answer-sheet'); return false;">Answer Sheet</a>)
        `;
    }
    
    // Populate marks
    const marksList = document.getElementById('marksList');
    let marksHTML = '<ul>';
    
    // Set max marks based on course
    let maxMarks;
    if (selectedCourse === 'DCET') {
        maxMarks = 15;
    } else if (selectedCourse === 'JEE') {
        maxMarks = 100;
    } else if (selectedCourse === 'NEET') {
        maxMarks = 180;
    } else if (selectedCourse === 'KCET') {
        maxMarks = 60;
    } else if (selectedCourse === 'Foundation') {
        maxMarks = 100;
    }
    
    for (let subject in marks) {
        marksHTML += `<li>${subject}: ${marks[subject]}/${maxMarks}</li>`;
    }
    
    marksHTML += '</ul>';
    marksList.innerHTML = marksHTML;
    
    // Hide AI analysis
    document.getElementById('aiAnalysis').classList.remove('active');
}

function showDocument(docType) {
    let message = '';
    const studentName = studentsData[selectedCourse][currentStudent].name;
    
    if (docType.startsWith('unit-test-')) {
        const testNum = docType.includes('test1') ? '1' : '2';
        message = `Opening Unit Test ${testNum} for ${studentName}`;
    } else if (docType.startsWith('omr-')) {
        const testNum = docType.includes('test1') ? '1' : '2';
        message = `Opening OMR Sheet (Test ${testNum}) for ${studentName}`;
    } else if (docType === 'omr') {
        message = `Opening OMR Sheet for ${studentName}`;
    } else if (docType === 'question-paper') {
        message = `Opening Question Paper for ${studentName}`;
    } else if (docType === 'answer-sheet') {
        message = `Opening Answer Sheet for ${studentName}`;
    }
    alert(message + '\n\nNote: Document viewing functionality will be implemented with actual document links.');
}

function showAIAnalysis() {
    if (!currentStudent || !selectedCourse) {
        return;
    }

    const student = studentsData[selectedCourse][currentStudent];
    let marks;
    
    // Get marks based on course
    if (selectedCourse === 'DCET') {
        if (!selectedTest) {
            alert('Please select a test first');
            return;
        }
        marks = student[selectedTest].marks;
    } else {
        marks = student.marks;
    }
    
    const weakSubjects = [];
    
    // Determine threshold based on course (60% of max marks)
    let threshold;
    if (selectedCourse === 'DCET') {
        threshold = 9; // 60% of 15
    } else if (selectedCourse === 'JEE') {
        threshold = 60; // 60% of 100
    } else if (selectedCourse === 'NEET') {
        threshold = 108; // 60% of 180
    } else if (selectedCourse === 'KCET') {
        threshold = 36; // 60% of 60
    } else if (selectedCourse === 'Foundation') {
        threshold = 60; // 60% of 100
    }
    
    // Find weak subjects
    for (let subject in marks) {
        if (marks[subject] < threshold) {
            weakSubjects.push(subject);
        }
    }
    
    // Update AI analysis
    document.getElementById('weakSubjects').textContent = weakSubjects.length > 0 ? weakSubjects.join(', ') : 'None - Great performance!';
    
    // Update reason based on weak subjects
    const reasonElement = document.getElementById('reason');
    if (weakSubjects.length > 0) {
        reasonElement.textContent = 'Conceptual clarity and insufficient numerical practice in weak areas.';
    } else {
        reasonElement.textContent = 'Excellent understanding across all subjects. Keep up the good work!';
    }
    
    // Update suggestions based on course
    const suggestionsElement = document.getElementById('suggestions');
    let suggestions = [];
    
    if (selectedCourse === 'DCET') {
        if (weakSubjects.length > 0) {
            suggestions = [
                'Revise core formulas daily',
                'Solve previous year DCET questions',
                'Focus more on numerical problem-solving',
                'Allocate extra 1 hour daily for weak subjects',
                'Practice mock tests regularly'
            ];
        } else {
            suggestions = [
                'Continue solving previous year papers',
                'Focus on time management',
                'Take advanced level mock tests',
                'Help peers with difficult concepts'
            ];
        }
    } else if (selectedCourse === 'JEE') {
        if (weakSubjects.length > 0) {
            suggestions = [
                'Practice more numerical problems in weak subjects',
                'Focus on conceptual understanding',
                'Solve previous year JEE Main and Advanced papers',
                'Create a formula sheet for quick revision',
                'Join doubt clearing sessions'
            ];
        } else {
            suggestions = [
                'Attempt JEE Advanced level problems',
                'Focus on reducing silly mistakes',
                'Practice under timed conditions',
                'Explore olympiad level questions'
            ];
        }
    } else if (selectedCourse === 'NEET') {
        suggestions = [
            'Strengthen your Biology diagrams and terminology',
            'Practice more numerical in Physics',
            'Focus on organic chemistry reactions',
            'Solve previous year NEET questions daily'
        ];
    } else if (selectedCourse === 'KCET') {
        suggestions = [
            'Review state board syllabus thoroughly',
            'Practice more KCET-specific question patterns',
            'Focus on speed and accuracy',
            'Solve previous year KCET papers'
        ];
    } else if (selectedCourse === 'Foundation') {
        if (weakSubjects.length > 0) {
            suggestions = [
                'Build strong fundamentals in weak subjects',
                'Practice regularly with foundation level problems',
                'Focus on conceptual clarity',
                'Take help from faculty for doubt clearing'
            ];
        } else {
            suggestions = [
                'Continue building strong fundamentals',
                'Move to advanced level topics',
                'Help classmates with their doubts',
                'Participate in academic competitions'
            ];
        }
    }
    
    let suggestionsHTML = '';
    suggestions.forEach(suggestion => {
        suggestionsHTML += `<li>${suggestion}</li>`;
    });
    suggestionsElement.innerHTML = suggestionsHTML;
    
    // Show AI analysis
    document.getElementById('aiAnalysis').classList.add('active');
}
