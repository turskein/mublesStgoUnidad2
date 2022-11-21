import React, { Component } from 'react'
import Keycloak from 'keycloak-js';

class NavbarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }

        this.handleSignInClick = this.handleSignInClick.bind(this);
        this.handleLogOutInClick = this.handleLogOutInClick.bind(this);
    }
    handleLogOutInClick(){
        this.state.keycloak.logout();
        
    }

    handleSignInClick(){
        this.state.keycloak.login();
    }

    componentDidMount(){
        var logIn = document.getElementById('log-in');
        var logOut = document.getElementById('log-out');
        logIn.hidden = false;
        logOut.hidden = true;

        const keycloak = new Keycloak({
            url: 'http://localhost:8082/',
            realm: 'spring-boot',
            clientId: 'muebles-stgo'
        });

        keycloak.init({
            onLoad: 'check-sso'
        }).then(authenticated => {
            if(authenticated){
                keycloak.loadUserInfo().then((userInfo) => {
                    this.setState({
                        name: userInfo.name,
                        email: userInfo.email,
                        id: userInfo.sub,
                        roles: keycloak.tokenParsed.realm_access.roles,
                    });
                    localStorage.setItem('token', keycloak.token);
                    console.log(keycloak.idToken);
                });
                logIn.hidden = true;
                logOut.hidden = false;
            }
            this.setState({
                authenticated: authenticated
            });
        })
        this.setState({
            keycloak: keycloak
        });
    }

    render() {
        return (
            <nav className="ps-4 navbar navbar-expand-lg navbar-dark bg-dark mb-3">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/">Tingeso 2022 :D</a>
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
                            <li className="nav-item">
                                <a className="nav-link" href="/salary/reports">Reportes de sueldos</a>
                            </li>
                        </ul>
                    </div>
                    <button type="button" className="btn btn-secondary" id="log-in" onClick={this.handleSignInClick}>Log In</button>
                    <button type="button" className="btn btn-secondary" id="log-out" onClick={this.handleLogOutInClick}>Log Out</button>
                </div>
                
            </nav>
        )
    }
}

export default NavbarComponent