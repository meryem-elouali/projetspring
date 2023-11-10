import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import { NavLink } from 'react-router-dom'; // Importez NavLink au lieu de Link
import './NavigationBar.css';

class NavigationBar extends React.Component {
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand as={NavLink} to="/">
                    <img
                        src="https://upload.wikimedia.org/wikipedia/commons/1/17/Tata_Tamo_Racemo.jpg"
                        width="25" height="25" alt="Logo"
                    />
                </Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link as={NavLink} to="/add">Ajouter Voiture</Nav.Link>
                    <Nav.Link as={NavLink} to="/list">Liste Voitures</Nav.Link>
                </Nav>
            </Navbar>
        );
    }
}

export default NavigationBar;
