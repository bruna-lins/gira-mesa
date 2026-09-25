import { useEffect, useState } from "react";
import Alert from "@mui/material/Alert";
import Container from "@mui/material/Container";

const API_URL = import.meta.env.VITE_API_URL;

function App() {
  const [saude, setSaude] = useState(null);

  //HOOK -> gancho
  useEffect(() => {
    async function verificarSaude() {
      try {
        const resposta = await fetch(`${API_URL}/api/health`);
        const texto = await resposta.text();
        setSaude({ ok: resposta.ok, mensagem: texto });
      } catch {
        setSaude({
          ok: false,
          mensagem: "Não foi possível estabelecer conexão com a API.",
        });
      }
    }

    verificarSaude();
  }, []);

  return (
    <Container maxWidth="sm" sx={{ mt: 8 }}>
      {saude && (
        <Alert severity={saude.ok ? "success" : "error"}>
          {saude.mensagem}
        </Alert>
      )}
    </Container>
  );
}

export default App;
