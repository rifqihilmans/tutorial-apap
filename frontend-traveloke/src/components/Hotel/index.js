import React from "react";
import classes from "./styles.module.css";
import Button from "../../components/Button";

const Hotel = (props) => {
    const { id, namaHotel, alamat, nomorTelepon, namaKamar, kapasitasKamar, handleEdit, handleDelete } = props;
    return (
        <div className={classes.hotel}>
            <h3>{`ID Hotel ${id}`}</h3>
            <p>{`Nama Hotel: ${namaHotel}`}</p>
            <p>{`Alamat: ${alamat}`}</p>
            <p>{`Nomor telepon: ${nomorTelepon}`}</p>
            <p>List kamar:</p>
            <p>{`${namaKamar}`}</p>
            <p>{`${kapasitasKamar}`}</p>
            <Button onClick={handleEdit} variant="success">
                Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
                Delete
            </Button>
        </div>
    );
};

export default Hotel;