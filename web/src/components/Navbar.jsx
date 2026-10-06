import { Link } from "react-router";
import AppBar from "@mui/material/AppBar";
import Button from "@mui/material/Button";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";

function Navbar() {
  return (
    <AppBar position="static" sx={{ bgcolor: "grey.900" }}>
      <Toolbar>
        <Typography
          variant="h6"
          component={Link}
          to="/"
          sx={{
            flexGrow: 1,
            color: "inherit",
            textDecoration: "none",
            textAlign: "left",
          }}
        >
          Gira Mesa
        </Typography>

        <Button color="inherit" component={Link} to="/">
          Início
        </Button>
        <Button color="inherit" component={Link} to="/health">
          Health
        </Button>
      </Toolbar>
    </AppBar>
  );
}

export default Navbar;
