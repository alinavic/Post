function toggleForm() {
    var dataType = document.getElementById('dataType').value;
    var peopleForm = document.getElementById('peopleForm');
    var organizationForm = document.getElementById('organizationForm');

    peopleForm.classList.remove('hidden');

    if (dataType === 'people') {
        peopleForm.classList.remove('hidden');
        organizationForm.classList.add('hidden');
    } else if (dataType === 'organization') {
        peopleForm.classList.add('hidden');
        organizationForm.classList.remove('hidden');
    }
}

