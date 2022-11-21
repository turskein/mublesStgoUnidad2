import React, { Component } from 'react';

class IndexComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            name: null,
            email: null,
            id: null,
            roles: null,
            authenticated: null,
            keycloak: null,
        }
        
    }

    render() {
        return (
            <div className='container'>

                <div className="col-6 mx-auto">
                </div>

            </div>
        )
    }
}

export default IndexComponent