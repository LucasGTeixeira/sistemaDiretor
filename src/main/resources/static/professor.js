const fetchProfessor = (id) => {
    const resp = await fetch(`http://localhost:5432/professores/${id}`)
    const data = await resp.json()
    return data
}

const fetchProfessores = () => {
    const resp = await fetch(`http://localhost:5432/professores`)
    const data = await resp.json()
    return data
}

const deleteProfessor = (id) => {
    await fetch(`http://localhost:5432/professores/${id}/delete`, {
        method: 'DELETE'
    })
}

saveProfessor = (professor)=>{
    let newProfessor = {
      nomeCompleto: professor.nome,
      numRegistro: professor.numRegistro,
      status: professor.status,
      curso: professor.curso
    }
    const addProfessor = async ()=>{
        const resp = await fetch('http://localhost:5432/professores/new', {
        method: 'POST',
        headers:{
            'Content-type': 'application/json'
        },
        body: JSON.stringify(newProfessor)
        })

        const data = await resp.json()
    }
    addProfessor();
}
