function updateSubjects() {
    const course = document.getElementById('course').value;
    const subject = document.getElementById('subject');
    const year = document.getElementById('year');
    console.log(course)

    const noneOption = [{ value: 'None', text: 'None' }];

    const allSubjects = [
        { value: 'None', text: 'None' },
        { value: 'Computer Science and Engineering', text: 'Computer Science and Engineering' },
        { value: 'Artificial Intelligence & Machine Learning', text: 'Artificial Intelligence & Machine Learning' },
        { value: 'Artificial Intelligence & Data Science', text: 'Artificial Intelligence & Data Science' },
        { value: 'Electrical Engineering', text: 'Electrical Engineering' },
        { value: 'Civil Engineering', text: 'Civil Engineering' },
        { value: 'Mechanical Engineering', text: 'Mechanical Engineering' }
    ];

    const mtechSubjects = [
        { value: 'None', text: 'None' },
        { value: 'Computer Science and Engineering', text: 'Computer Science and Engineering' },
        { value: 'Production Engineering', text: 'Production Engineering' }
    ];

    const mbaSubjects = [
        { value: 'None', text: 'None' },
        { value: 'Human Resource', text: 'Human Resource' },
        { value: 'Marketing', text: 'Marketing' },
        { value: 'Finance', text: 'Finance' }
    ];

    while (subject.options.length > 0) {
        subject.remove(0);
    }

    let subjects;
    if (course === 'B. Tech') {
        subjects = allSubjects;
    } else if (course === 'M. Tech') {
        subjects = mtechSubjects;
    } else {
        subjects = mbaSubjects;
    }

    subjects.forEach(subj => {
        const option = document.createElement('option');
        option.value = subj.value;
        option.text = subj.text;
        subject.add(option);
    });

    const noneYear = [
        { value: 'None', text: 'None' }
    ]

    const allYear = [
        { value: 'None', text: 'None' },
        { value: '1st', text: '1st' },
        { value: '2nd', text: '2nd' },
        { value: '3rd', text: '3rd' },
        { value: '4th', text: '4th' }
    ]

    const mbaYear = [
        { value: 'None', text: 'None' },
        { value: '1st', text: '1st' },
        { value: '2nd', text: '2nd' }
    ]

    const mtechYear = [
        { value: 'None', text: 'None' },
        { value: '1st', text: '1st' },
        { value: '2nd', text: '2nd' }
    ]

    while (year.options.length > 0) {
        year.remove(0);
    }

    let years;
    if (course === 'B. Tech') {
        years = allYear;
	}
	else if (course === 'M. Tech') {
        years = mtechYear;
    } else if (course === 'MBA') {
        years = mbaYear;
    } else {
        years = noneYear;
    }

    years.forEach(yr => {
        const option = document.createElement('option');
        option.value = yr.value;
        option.text = yr.text;
        year.add(option);
    });
}

