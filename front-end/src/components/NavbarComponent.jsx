import React, { Component } from 'react'

class NavbarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/">MUeblesStgo:D</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/uploadtimestamps">Cargar marcas de tiempo</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/">Cargar justificaciones</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/">Cargar horas extras</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/">Ver Salarios</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/">Ver Reportes</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        )
    }
}

export default NavbarComponent