import React, { Component } from 'react'

class NavbarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <nav className="ps-4 navbar navbar-expand-lg navbar-dark bg-dark mb-3">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/index">Tingeso 2022 :D</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className="nav-link" href="/uploadtimestamps">Cargar Marcaciones</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/upload-justifive">Cargar Justificativos</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/salary/sheet-salary">Plantilla de sueldos</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/salary/reports">Reportes de sueldos</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        )
    }
}

export default NavbarComponent