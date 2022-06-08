const fetchAluno = async (id) => {
    const resp = await fetch(`http://localhost:5432/alunos/${id}`)
    const data = await resp.json()
    return data
}

const fetchAlunos = async () => {
    const resp = await fetch(`http://localhost:5432/alunos`)
    const data = await resp.json()
    return data
}

const deleteAluno = async (id) => {
    await fetch(`http://localhost:5432/alunos/${id}/delete`, {
        method: 'DELETE'
    })
}

saveAluno = (aluno)=>{
    let newAluno = {
      nome: aluno.nome,
      registroAluno: aluno.registroAluno,
      status: aluno.status,
      curso: aluno.curso
    }
    const addAluno = async ()=>{
        const resp = await fetch('http://localhost:5432/alunos/new', {
        method: 'POST',
        headers:{
            'Content-type': 'application/json'
        },
        body: JSON.stringify(newAluno)
        })

        const data = await resp.json()
    }
    addAluno();
}
