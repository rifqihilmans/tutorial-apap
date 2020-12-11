import React from "react";
// import classes from "./styles.module.css";

const Kamar = (props) => {
    const { namaKamar, kapasitasKamar } = props;
    return (
        <div>
             <p>{`${namaKamar} (${kapasitasKamar})`}</p>
        </div>
    );
};

export default Kamar;