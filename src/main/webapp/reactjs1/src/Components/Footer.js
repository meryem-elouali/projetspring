import React from 'react';
import { Navbar, Container, Col } from 'react-bootstrap';
import "./Footer.css";
class Footer extends React.Component {
    render() {
        let fullYear = new Date().getFullYear();
        return (
            <Navbar fixed="bottom" bg="dark" variant="dark">
                <Container>
                    <Col lg={12} className="text-center text-muted">
                        <div className="footer-bar">
                            {fullYear}-{fullYear + 1}, All Rights Reserved by IDSIT
                        </div>
                    </Col>
                </Container>
            </Navbar>
        );
    }
}

export default Footer;
