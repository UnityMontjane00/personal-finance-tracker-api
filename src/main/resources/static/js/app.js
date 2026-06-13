let editingTransactionId = null;

document
    .getElementById("transactionForm")
    .addEventListener("submit", async function(event) {

    event.preventDefault();

    const transaction = {
        description: document.getElementById("description").value,
        amount: parseFloat(document.getElementById("amount").value),
        category: document.getElementById("category").value,
        type: document.getElementById("type").value,
        transactionDate: new Date().toISOString().split("T")[0]
    };

    try {

        const response = await fetch("/transactions", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(transaction)
        });

        const data = await response.json();

        console.log(data);

        alert("Transaction saved successfully!");

        document.getElementById("transactionForm").reset();

        loadTransactions();
        loadSummary();

    } catch (error) {

        console.error(error);

        alert("Failed to save transaction.");

    }

});


        async function loadTransactions() {


try {

    const response = await fetch("/transactions");

    const transactions = await response.json();

    const tableBody =
        document.querySelector("#transactionTable tbody");

    tableBody.innerHTML = "";

    transactions.forEach(transaction => {

        const row = `
            <tr>
            <td>${transaction.id}</td>
            <td>${transaction.description}</td>
            <td>
                R${transaction.amount.toLocaleString(undefined, {
            minimumFractionDigits: 2
        })}
</td>
            <td>${transaction.category}</td>
            <td>
                <span class="${
                        transaction.type === "INCOME"
                            ? "income-badge"
                            : "expense-badge"
                    }">
                    ${transaction.type}
                </span>
            </td>
            <td>
               <button class="edit-btn"
                        onclick="editTransaction(${transaction.id})">
                        Edit
                    </button>

                    <button class="delete-btn"
                         onclick="deleteTransaction(${transaction.id})">
                        Delete
                    </button>
        </tr>
            `;

        tableBody.innerHTML += row;

    });

} catch (error) {

    console.error(error);

}
        }
        async function loadSummary() {

const response = await fetch("/transactions");

const transactions = await response.json();

let income = 0;
let expenses = 0;

transactions.forEach(transaction => {

    if (transaction.type === "INCOME") {
        income += transaction.amount;
    } else if (transaction.type === "EXPENSE") {
        expenses += transaction.amount;
    }

});

const balance = income - expenses;

document.getElementById("income").textContent =
    `R${income.toFixed(2)}`;

document.getElementById("expenses").textContent =
    `R${expenses.toFixed(2)}`;

document.getElementById("balance").textContent =
    `R${balance.toFixed(2)}`;


        }

        async function editTransaction(id) {


alert("Edit feature coming next...");


        }

        async function deleteTransaction(id) {


const confirmed = confirm(
    "Are you sure you want to delete this transaction?"
);

if (!confirmed) {
    return;
}

await fetch(`/transactions/${id}`, {
    method: "DELETE"
});

loadTransactions();
loadSummary();


        }

        loadTransactions();
        loadSummary();
