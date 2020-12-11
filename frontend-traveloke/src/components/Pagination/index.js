import React from "react";

const Pagination = ({total, page, paginate}) => {
    const numbers = [];
    for (let i = 1; i <= Math.ceil(total / page); i++) {
        numbers.push(i);
    }
    
    return (
        <nav>
            <ul>
                {numbers.map(number => (
                    <li >
                        <a onClick={() => paginate(number)} href="!#">{number}</a>
                    </li>
                ))}
            </ul>
        </nav>
    )

}

export default Pagination;