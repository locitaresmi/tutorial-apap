import React from 'react'

const Search = (props) => {

    const {children} = props;
    
    return (
        <form>
            <div className="form-group row">
                <div className="col-12 d-flex justify-content-center">
                    {children}
                </div>
            </div>
        </form>
    )
}

export default Search
