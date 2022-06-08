const fetchCurso = (id) => {
    const resp = await fetch(`http://localhost:5432/cursos/${id}`)
    const data = await resp.json()
    return data
}

const fetchCursos = () => {
    const resp = await fetch(`http://localhost:5432/cursos`)
    const data = await resp.json()
    return data
}


const deleteCurso = (id) => {
    await fetch(`http://localhost:5432/cursos/${id}/delete`, {
        method: 'DELETE'
    })
}

saveCursos = (curso)=>{
    let newCurso = {
      nome: curso.nome,
      codigo: curso.numRegistro
    }
    const addCurso = async ()=>{
        const resp = await fetch('http://localhost:5432/cursos/new', {
        method: 'POST',
        headers:{
            'Content-type': 'application/json'
        },
        body: JSON.stringify(newCurso)
        })

        const data = await resp.json()
    }
    addCurso();
}